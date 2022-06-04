package com.example.fgoressource.NA.Detailled.Skills.Skill;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.fgoressource.NA.Detailled.Skills.FragmentBase;
import com.example.fgoressource.NA.Detailled.Skills.FragmentTab;
import com.example.fgoressource.NA.Detailled.Skills.FragmentUpgrade;
import com.example.fgoressource.NA.Detailled.VPAdapter;
import com.example.fgoressource.R;
import com.google.android.material.tabs.TabLayout;

public class Skill1 extends Fragment {

    public Skill1(/*JSONArray skillList*/) {
        super(R.layout.skill_upgrade);
        //_skillList = skillList;
    }

    @Override
    public void onViewCreated(@NonNull View container, Bundle savedInstanceState) {
        VPAdapter vpAdapter = new VPAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        //private JSONArray _skillList;
        TabLayout tabLayoutSkills = container.findViewById(R.id.skillUpgrade1);
        ViewPager viewPagerSkills = container.findViewById(R.id.VPTest);
        tabLayoutSkills.setupWithViewPager(viewPagerSkills);
        vpAdapter.addFragment(new FragmentBase(), "Base");
        vpAdapter.addFragment(new FragmentUpgrade(), "Upgraded");
        vpAdapter.addFragment(new FragmentTab(), "tab");
        viewPagerSkills.setAdapter(vpAdapter);
        ((LinearLayout) tabLayoutSkills.getTabAt(2).view).setVisibility(View.GONE);
    }
}
