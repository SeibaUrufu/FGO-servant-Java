package com.example.fgoressource.NA.MainView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fgoressource.NA.Detailled.NAServantDetailled;
import com.example.fgoressource.R;
import com.example.fgoressource.VolleyRequestQueue;

public class NAServantList extends AppCompatActivity implements IServant{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.servant_list);

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

    }

    @Override
    public void onClick(ServantViewHolder holder, int position) {
        String _id = holder.getID().getText().toString();
        Intent servant = new Intent(NAServantList.this, NAServantDetailled.class);
        servant.putExtra("ID", _id);
        startActivity(servant);
    }

}
