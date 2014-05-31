package com.formigone.nintendo.tictactoe.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.formigone.nintendo.tictactoe.R;
import com.formigone.nintendo.tictactoe.adapter.BoardAdapter;
import com.formigone.nintendo.tictactoe.model.Cell;
import com.formigone.nintendo.tictactoe.model.Player;

public class GameActivity extends Activity {
    private static final String TAG = "GameActivity";
    private final int TOTAL_CELLS = 9;

    private Player[] mPlayers;
    private int mTurn;
    
    private GridView mBoard;
    private List<Cell> mCells;
    private BoardAdapter mCellAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

	mPlayers = new Player[2];
	mTurn = 0;
	mCells = new ArrayList<Cell>();

	mPlayers[0] = new Player(R.string.player_nes, R.drawable.ic_launcher);
	mPlayers[0] = new Player(R.string.player_gameboy, R.drawable.ic_launcher);

	setContentView(R.layout.game_board);
	mBoard = (GridView) findViewById(R.id.board_grid);

	for (int i = 0; i < TOTAL_CELLS; i++) {
	    mCells.add(new Cell(i, R.layout.board_cell));
	}

	mCellAdapter = new BoardAdapter(mCells);
	mBoard.setAdapter(mCellAdapter);
	mBoard.setOnItemClickListener(mOnCellClick);
    }

    private OnItemClickListener mOnCellClick = new OnItemClickListener() {

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
		long id) {
	    Cell cell = mCells.get(position);
	    Log.i(TAG, "Cell id " + cell.getId());
	}
    };
}
