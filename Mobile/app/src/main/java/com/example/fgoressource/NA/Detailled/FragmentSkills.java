package com.example.fgoressource.NA.Detailled;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.View;

import com.example.fgoressource.NA.Detailled.Skills.Skill.*;
import com.example.fgoressource.R;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;

public class FragmentSkills extends Fragment {

    private JSONArray _skills;

    private TabLayout tabLayoutSkills;
    private ViewPager viewPagerSkills;

    public FragmentSkills(JSONArray skills) {
        super(R.layout.fragment_skills);
        this._skills=skills;
    }

    @Override
    public void onViewCreated(@NonNull View container, Bundle savedInstanceState) {
        VPAdapter vpAdapter = new VPAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        tabLayoutSkills = (TabLayout) container.findViewById(R.id.skillMenu);
        viewPagerSkills = (ViewPager) container.findViewById(R.id.viewPagerSkills);
        tabLayoutSkills.setupWithViewPager(viewPagerSkills);
        vpAdapter.addFragment(new Skill1(), "Skill1");
        vpAdapter.addFragment(new Skill2(), "Skill2");
        vpAdapter.addFragment(new Skill3(), "Skill3");
        viewPagerSkills.setAdapter(vpAdapter);
    }
}