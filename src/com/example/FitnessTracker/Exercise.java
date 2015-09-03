package com.example.FitnessTracker;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.app.Activity;
import android.text.InputType;
import android.util.Log;
import android.view.*;
import android.widget.*;

import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Calendar;

public class Exercise extends Activity {

    Button savebutton, cancelbutton, gobutton, nobutton, addnote, deletenotes;
    EditText dateinput, weightinput, repsinput;
    private int dd, mm, yy;
    String notes = "";
    DBTracker dbtrack = new DBTracker(this);
    DBNotes dbnote = new DBNotes(this);


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        DecimalFormat mFormat = new DecimalFormat("00");
        mFormat.setRoundingMode(RoundingMode.DOWN);


        switch (item.getItemId()) {
            case R.id.addinfo:
                Dialog dialog = new Dialog(Exercise.this);
                dialog.setTitle("        Enter your STATS brah");
                dialog.setContentView(R.layout.datainput);

                dateinput = (EditText) dialog.findViewById(R.id.editDate);
                final Calendar c = Calendar.getInstance();
                dd = c.get(Calendar.DAY_OF_MONTH);
                mm = c.get(Calendar.MONTH);
                yy = c.get(Calendar.YEAR);

                String mmm = mFormat.format(Double.valueOf(mm + 1));
                String ddd = mFormat.format(Double.valueOf(dd));

                dateinput.setText(new StringBuilder().append(ddd).append("/").append(mmm).append("/").append(yy));

                dialog.show();

                weightinput = (EditText) dialog.findViewById(R.id.editWeight);
                repsinput = (EditText) dialog.findViewById(R.id.editReps);

                savebutton = (Button) dialog.findViewById(R.id.btnSave);
                cancelbutton = (Button) dialog.findViewById(R.id.btnCancel);

                savebutton.setOnClickListener(new View.OnClickListener() {


                    @Override
                    public void onClick(View view) {

                        try {
                            dbtrack.open();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                        insert();
                        populateTrackListView();
                        Toast.makeText(Exercise.this, "POWER", Toast.LENGTH_SHORT).show();
                        dialog.cancel();


                    }
                });

                cancelbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });


                return true;
            default:
                return super.onOptionsItemSelected(item);


            case R.id.notes:
                Dialog notesDialog = new Dialog(Exercise.this);
                notesDialog.setContentView(R.layout.notes);
                notesDialog.show();

                addnote = (Button) notesDialog.findViewById(R.id.addnote);
                deletenotes = (Button) notesDialog.findViewById(R.id.deletenotes);


                addnote.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(Exercise.this);
                        builder.setTitle("Add Note");


                        final EditText input = new EditText(Exercise.this);

                        input.setInputType(InputType.TYPE_CLASS_TEXT);
                        builder.setView(input);

                        builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                        builder.setNegativeButton("Save", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                notes = input.getText().toString();

                                try {
                                    openNotesDB();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }

                                try {
                                    dbnote.insertRecord(notes);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                //populateNotesListView();

                            }
                        });

                        builder.show();

                    }
                });

                return true;


            case R.id.graph:
                Dialog graphdialog = new Dialog(Exercise.this);
                graphdialog.setTitle("COMING SOON!");
                graphdialog.show();
                return true;


            case R.id.delete:
                Dialog warning = new Dialog(Exercise.this);
                warning.setTitle("DON'T ACT RECKLESS-CTMN");
                warning.setContentView(R.layout.warning);
                warning.show();

                gobutton = (Button) warning.findViewById(R.id.btnGo);
                nobutton = (Button) warning.findViewById(R.id.btnNo);

                gobutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        delete();
                        warning.setContentView(R.layout.swipe_layout);
                        populateTrackListView();
                        warning.cancel();
                        dbtrack.close();

                    }
                });
                nobutton.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        warning.cancel();
                    }
                });


        }

        return true;

    }


    protected void openTrackDB() throws SQLException {
        dbtrack = new DBTracker(this);
        dbtrack.open();
    }

    protected void openNotesDB() throws SQLException {
        dbnote = new DBNotes(this);
        dbnote.open();
    }

    protected void insert() {
    }

    protected void populateTrackListView() {
    }

    protected void delete() {
    }

    protected boolean longClick() {
    return true;
    }

    /*
    protected void populateNotesListView(){
        Cursor cursor = dbnote.getAllRows();
        String[] fromFieldnames = new String[]{DBNotes.COL_1};
        int[] toViewIds = new int[]{R.id.textView2};
        SimpleCursorAdapter myCursorAdapter;
        myCursorAdapter = new SimpleCursorAdapter(getBaseContext(),R.layout.notes,cursor,fromFieldnames,toViewIds,0);
        ListView myList= (ListView) findViewById(R.id.statsview);
        Log.d(getPackageName(),myList != null ? "not null":"Null");
        myList.setAdapter(myCursorAdapter);


    }
*/




}









