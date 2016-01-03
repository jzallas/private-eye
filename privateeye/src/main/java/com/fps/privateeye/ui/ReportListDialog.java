package com.fps.privateeye.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.fps.privateeye.R;
import com.fps.privateeye.ui.adapters.ReportListAdapter;
import com.fps.privateeye.evidence.EvidenceStore;

public final class ReportListDialog extends AlertDialog {

  private RecyclerView mRecyclerView;
  private ReportListAdapter mAdapter;
  private EvidenceStore mEvidenceStore;

  public static ReportListDialog create(Context context){
    return new ReportListDialog(context);
  }

  public ReportListDialog attachReports(EvidenceStore evidenceStore){
    mEvidenceStore = evidenceStore;
    return this;
  }

  protected ReportListDialog(Context context) {
    super(context);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.fragment_report_list);
    mRecyclerView = (RecyclerView) findViewById(R.id.pi_recycler_view);

    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
    layoutManager.setOrientation(LinearLayout.VERTICAL);
    mRecyclerView.setLayoutManager(layoutManager);
    mAdapter = new ReportListAdapter(mEvidenceStore);
    mRecyclerView.setAdapter(mAdapter);
  }

}
