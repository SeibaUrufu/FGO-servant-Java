package com.example.fgoressource.NA.MainView;

import android.content.Intent;
import android.os.Bundle;
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

        //Declaration of a Button and a FragmentContainerView to filter the list
        Button options = findViewById(R.id.searchNameButton);
        FragmentContainerView optionsContainer = findViewById(R.id.optionsFragContainer);

        VolleyRequestQueue.getInstance(this);

        //Creation of the ViewModel
        ServantViewModel model = new ViewModelProvider(this).get(ServantViewModel.class);

        //Observer on the ViewModel
        model.getList().observe(this, servMLD -> {
            LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            RecyclerView _recyclerView = findViewById(R.id.servantRecycler);
            ServantAdapter _adapter = new ServantAdapter(servMLD);
            _adapter.getItemCount();

            _recyclerView.setLayoutManager(layoutManager);
            _recyclerView.setAdapter(_adapter);
            _adapter.setOnItemClickListener(this);
        });

        //Reaction on the filter button
        options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(optionsOn) { //If the filter section is open, we change the value to false, change the text and make it invisible
                    optionsOn = false;
                    options.setText("↓");
                    optionsContainer.setVisibility(View.INVISIBLE);
                } else { //Else we change the value to false, change the text and get the fragment to be shown
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
        Intent servant = new Intent(NAServantList.this, NAServantDetailled.class); //Intent to pass some data to the next activity
        servant.putExtra("ID", _id);
        startActivity(servant); //Will direct us to the activity showing detailed information on the servant
    }

}
