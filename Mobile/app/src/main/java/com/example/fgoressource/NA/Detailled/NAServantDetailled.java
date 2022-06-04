package com.example.fgoressource.NA.Detailled;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.example.fgoressource.NA.MainView.ServantAdapter;
import com.example.fgoressource.R;
import com.example.fgoressource.VolleyRequestQueue;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NAServantDetailled extends AppCompatActivity {

    private String _id;
    private TextView servantName;
    private TextView servAtkMin;
    private TextView servAtkMax;
    private TextView servHPMin;
    private TextView servHPMax;
    private TextView servStarA;
    private TextView servStarG;
    private TextView servNPD;
    private TextView servNPG;
    private TextView servAttribut;
    private TextView servAlignement;
    private TextView servDeathRate;
    private ImageView servGraph;
    private Button asc1;
    private Button asc2;
    private Button asc3;
    private Button asc4;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.servant_detailled_na);
        VPAdapter vpAdapter = new VPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        tabLayout = (TabLayout) findViewById(R.id.dataLayout);
        viewPager = (ViewPager) findViewById(R.id.dataViewPager);
        servantName = (TextView) findViewById(R.id.servName);
        servAtkMin = (TextView) findViewById(R.id.atkMin);
        servAtkMax = (TextView) findViewById(R.id.atkMax);
        servHPMin = (TextView) findViewById(R.id.hpMin);
        servHPMax = (TextView) findViewById(R.id.hpMax);
        servStarA = (TextView) findViewById(R.id.starAbs);
        servStarG = (TextView) findViewById(R.id.starGen);
        servNPD = (TextView) findViewById(R.id.npDef);
        servNPG = (TextView) findViewById(R.id.npGen);
        servAttribut = (TextView) findViewById(R.id.attribut);
        servAlignement = (TextView) findViewById(R.id.alignement);
        servDeathRate = (TextView) findViewById(R.id.death);
        servGraph = (ImageView) findViewById(R.id.servantGraph);
        asc1 = (Button) findViewById(R.id.asc1);
        asc2 = (Button) findViewById(R.id.asc2);
        asc3 = (Button) findViewById(R.id.asc3);
        asc4 = (Button) findViewById(R.id.asc4);

        JSONObject skill_1 = new JSONObject();
        JSONObject skill_2 = new JSONObject();
        JSONObject skill_3 = new JSONObject();
        JSONObject skills = new JSONObject();

        Bundle servant = getIntent().getExtras();
        _id = servant.getString("ID");
        Log.d("Servant ID", _id);


        DetailledViewModel model = new ViewModelProvider(this, new DetailledViewModelFactory(_id)).get(DetailledViewModel.class);
        model.getList().observe(this, servMLD -> {
            DetailledAdapter _adapter = new DetailledAdapter(servMLD);
            _adapter.getItemCount();
            Log.d("MDL", String.valueOf(servMLD));
            try {
                servantName.setText(servMLD.getString("name"));
                servAtkMin.setText(String.format("Atk min: %s", servMLD.getString("atkBase")));
                servAtkMax.setText(String.format("Atk max: %s", servMLD.getString("atkMax")));
                servHPMin.setText(String.format("HP min: %s", servMLD.getString("hpBase")));
                servHPMax.setText(String.format("HP max: %s", servMLD.getString("hpMax")));
                servStarA.setText(String.format("Star abs: %s", servMLD.getString("starAbsorb")));
                servStarG.setText(String.format("Star gen: %s%%", parseFloat(servMLD.getString("starGen"))/10));
                servNPG.setText(String.format("NP charge Atk: %s%%", parseFloat(String.valueOf(servMLD.getJSONArray("noblePhantasms").getJSONObject(0).getJSONObject("npGain").getJSONArray("arts").get(0)))/100));
                servNPD.setText(String.format("NP charge Def: %s%%", parseFloat(String.valueOf(servMLD.getJSONArray("noblePhantasms").getJSONObject(0).getJSONObject("npGain").getJSONArray("defence").get(0)))/100));
                servAttribut.setText(String.format("Attribut: %s", servMLD.getString("attribute")));
                servAlignement.setText(String.format("Alignement: %s/%s", servMLD.getJSONArray("traits").getJSONObject(3).getString("name").substring(9), servMLD.getJSONArray("traits").getJSONObject(4).getString("name").substring(9)));
                servDeathRate.setText(String.format("Death Rate: %s%%", parseFloat(String.valueOf(servMLD.getString("instantDeathChance")))/10));
                String _graphURL = servMLD.getJSONObject("extraAssets").getJSONObject("charaGraph").getJSONObject("ascension").getString("1");
                setGraph(_graphURL);

                asc1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String _graphURLChange = null;
                        try {
                            _graphURLChange = servMLD.getJSONObject("extraAssets").getJSONObject("charaGraph").getJSONObject("ascension").getString("1");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        setGraph(_graphURLChange);
                    }
                });

                asc2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String _graphURLChange = null;
                        try {
                            _graphURLChange = servMLD.getJSONObject("extraAssets").getJSONObject("charaGraph").getJSONObject("ascension").getString("2");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        setGraph(_graphURLChange);
                    }
                });

                asc3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String _graphURLChange = null;
                        try {
                            _graphURLChange = servMLD.getJSONObject("extraAssets").getJSONObject("charaGraph").getJSONObject("ascension").getString("3");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        setGraph(_graphURLChange);
                    }
                });

                asc4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("ButtonTest", "Ascension 4");
                        String _graphURLChange = null;
                        try {
                            _graphURLChange = servMLD.getJSONObject("extraAssets").getJSONObject("charaGraph").getJSONObject("ascension").getString("4");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        setGraph(_graphURLChange);
                    }
                });


                int _counter;
                skills.put("id", servMLD.getInt("collectionNo"));
                List<Integer> skill_1Index = new ArrayList<>();
                List<Integer> skill_2Index = new ArrayList<>();
                List<Integer> skill_3Index = new ArrayList<>();
                int counter1 = 0;
                int counter2 = 0;
                int counter3 = 0;
                for(_counter = 0; _counter < servMLD.getJSONArray("skills").length(); _counter++) {
                    if(servMLD.getJSONArray("skills").getJSONObject(_counter).getInt("num") == 1) {
                        skill_1Index.add(_counter);
                        counter1++;
                    } else if(servMLD.getJSONArray("skills").getJSONObject(_counter).getInt("num") == 2) {
                        skill_2Index.add(_counter);
                        counter2++;
                    } else if(servMLD.getJSONArray("skills").getJSONObject(_counter).getInt("num") == 3) {
                        skill_3Index.add(_counter);
                        counter3++;
                    }
                }
                skill_1.put("number", counter1);
                skill_1.put("index", skill_1Index);
                skills.put("skill1", skill_1);

                skill_2.put("number", counter2);
                skill_2.put("index", skill_2Index);
                skills.put("skill2", skill_2);

                skill_3.put("number", counter3);
                skill_3.put("index", skill_3Index);
                skills.put("skill3", skill_3);

                Log.d("Skills", String.valueOf(skills));
                Log.d("Skill1", String.valueOf(servMLD.getJSONArray("skills").getJSONObject(0)));


                tabLayout.setupWithViewPager(viewPager);
                vpAdapter.addFragment(new FragmentTraits(servMLD.getJSONArray("traits")), "Traits");
                vpAdapter.addFragment(new FragmentSkills(servMLD.getJSONArray("skills")), "Skills");
                vpAdapter.addFragment(new FragmentPassive(servMLD.getJSONArray("classPassive")), "Passive skills");
                vpAdapter.addFragment(new FragmentNP(), "NP");
                vpAdapter.addFragment(new FragmentCards(servMLD.getJSONArray("cards"), servMLD.getJSONObject("hitsDistribution")), "Cards");
                viewPager.setAdapter(vpAdapter);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
    }

    private void setGraph(String graphURL) {
        ImageRequest request = new ImageRequest(
                graphURL,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        servGraph.setImageBitmap(response);
                    }
                },
                0,
                0,
                ImageView.ScaleType.CENTER,
                Bitmap.Config.RGB_565,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("ICON_LOADING", error.getMessage());
                    }
                }
        );
        VolleyRequestQueue.getInstance().add(request);
    }

}
