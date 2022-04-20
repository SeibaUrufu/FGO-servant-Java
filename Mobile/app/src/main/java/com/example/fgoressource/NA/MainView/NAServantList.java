package com.example.fgoressource.NA.MainView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fgoressource.NA.Detailled.NAServantDetailled;
import com.example.fgoressource.R;
import com.example.fgoressource.VolleyRequestQueue;

public class NAServantList extends AppCompatActivity implements IServant{

    private Boolean optionsOn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.servant_list);

        Button options = (Button) findViewById(R.id.searchNameButton);
        FragmentContainerView optionsContainer = (FragmentContainerView) findViewById(R.id.optionsFragContainer);

        VolleyRequestQueue.getInstance(this);

        ServantViewModel model = new ViewModelProvider(this).get(ServantViewModel.class);

        model.getList().observe(this, servMLD -> {
            LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            RecyclerView _recyclerView = (RecyclerView) findViewById(R.id.servantRecycler);
            ServantAdapter _adapter = new ServantAdapter(servMLD);
            _adapter.getItemCount();

            _recyclerView.setLayoutManager(layoutManager);
            _recyclerView.setAdapter(_adapter);
            _adapter.setOnItemClickListener(this);
        });

        options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(optionsOn) {
                    optionsOn = false;
                    options.setText("↓");
                    optionsContainer.setVisibility(View.INVISIBLE);
                } else {
                    optionsOn = true;
                    optionsContainer.setVisibility(View.VISIBLE);
                    options.setText("↑");
                    getSupportFragmentManager()
                            .beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.optionsFragContainer, OptionsFilter.class, null)
                            .addToBackStack("true")
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            .commit();
                }
            }
        });

    }

    @Override
    public void onClick(ServantViewHolder holder, int position) {
        String _id = holder.getID().getText().toString();
        Intent servant = new Intent(NAServantList.this, NAServantDetailled.class);
        servant.putExtra("ID", _id);
        startActivity(servant);
    }

}
