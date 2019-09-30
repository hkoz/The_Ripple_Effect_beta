package com.therippleeffect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AcceptQuestActivity extends AppCompatActivity {


    TextView puddleName;
    TextView dateCreated;
    TextView initiator;
    TextView quest;
    TextView countryLocation;
    TextView cityLocation;
    TextView requiredRipples;
    TextView createdRipples;
    TextView type;
    TextView status;
    TextView credibility;
    TextView reports;
    TextView details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept_quest);

        puddleName=findViewById(R.id.puddle_name_text);
        initiator=findViewById(R.id.initiator_name_text);
        dateCreated=findViewById(R.id.date_text);
        quest=findViewById(R.id.quest_text);
        countryLocation=findViewById(R.id.location_country_text);
        cityLocation=findViewById(R.id.location_city_text);
        requiredRipples=findViewById(R.id.required_ripple_text);
        createdRipples =findViewById(R.id.ripples_created_text);
        type=findViewById(R.id.type_text);
        status=findViewById(R.id.Status_text);
        credibility=findViewById(R.id.credibility_text);
        reports=findViewById(R.id.reports_text);
        details=findViewById(R.id.details_text);

        puddleName.setText(getIntent().getStringExtra(getString(R.string.puddleNameKey)));
        initiator.setText(getIntent().getStringExtra(getString(R.string.initiatorKey)));
        dateCreated.setText(getIntent().getStringExtra(getString(R.string.dateKey)));
        quest.setText(getIntent().getStringExtra(getString(R.string.questKey)));
        countryLocation.setText(getIntent().getStringExtra(getString(R.string.countryKey)));
        cityLocation.setText(getIntent().getStringExtra(getString(R.string.cityKey)));
        requiredRipples.setText(getIntent().getStringExtra(getString(R.string.reqRipplesKey)));
        createdRipples.setText(getIntent().getStringExtra(getString(R.string.createdRipplesKey)));
        type.setText(getIntent().getStringExtra(getString(R.string.typeKey)));
        status.setText(getIntent().getStringExtra(getString(R.string.statusKey)));
        credibility.setText(getIntent().getStringExtra(getString(R.string.credibilityKey)));
        reports.setText(getIntent().getStringExtra(getString(R.string.reportsKey)));
        details.setText(getIntent().getStringExtra(getString(R.string.detailsKey)));

    }
}
