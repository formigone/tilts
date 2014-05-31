package com.formigone.nintendo.tictactoe.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.formigone.nintendo.tictactoe.Constants;
import com.formigone.nintendo.tictactoe.R;
import com.formigone.nintendo.tictactoe.adapter.BoardAdapter;
import com.formigone.nintendo.tictactoe.model.Cell;
import com.formigone.nintendo.tictactoe.model.Cell.State;
import com.formigone.nintendo.tictactoe.model.Player;

public class GameActivity extends Activity {
    private static final String TAG = "GameActivity";
    private final int TOTAL_CELLS = 9;

    private Player[] mPlayers;
    private int mTurn;
    private boolean mIsGameover;

    private GridView mBoard;
    private List<Cell> mCells;
    private BoardAdapter mCellAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

	mPlayers = new Player[2];
	mTurn = 0;
	mIsGameover = false;
	mCells = new ArrayList<Cell>();

	mPlayers[0] = new Player(R.string.player_nes, R.drawable.controller_nes);
	mPlayers[1] = new Player(R.string.player_wii, R.drawable.controller_wii);

	setContentView(R.layout.game_board);
	mBoard = (GridView) findViewById(R.id.board_grid);

	for (int i = 0; i < TOTAL_CELLS; i++) {
	    mCells.add(new Cell(i, R.layout.board_cell));
	}

	mCellAdapter = new BoardAdapter(mCells);
	mBoard.setAdapter(mCellAdapter);
	mBoard.setOnItemClickListener(mOnCellClick);
    }
    
    private int getWinningPosition(State state) {
	int[][] toCheck = Constants.getPositions();
	
	for (int y = 0; y < 8; y++) {
	    int[] row = toCheck[y];
	    if (mCells.get(row[0]).getState() == state
		    && mCells.get(row[1]).getState() == state
		    && mCells.get(row[2]).getState() == state) {
		return y;
	    }
	}
	
	return -1;
    }

    private boolean isDraw() {
	boolean draw = true;
	
	for (int i = 0; i < TOTAL_CELLS; i++) {
	    if (mCells.get(i).getState() == State.EMPTY) {
		draw = false;
	    }
	}

	return draw;
    }
    
    private void highlightPosition(List<Integer> positions, int color) {
	for (Integer i: positions) {
	    mCells.get(i.intValue()).highlight(color);
	}
	
	mCellAdapter.notifyDataSetChanged();
    }
    
    private List<Integer> getPositionFor(State turn) {
	List<Integer> positions = new ArrayList<Integer>();
	
	for (int i = 0; i < TOTAL_CELLS; i++) {
	    if (mCells.get(i).getState() == turn) {
		positions.add(i);
	    }
	}
	
	return positions;
    }

    private OnItemClickListener mOnCellClick = new OnItemClickListener() {

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
		long id) {

	    if (mIsGameover) {
		return;
	    }

	    Cell cell = mCells.get(position);
	    State turn = mTurn == 0 ? State.PLAYER_ONE : State.PLAYER_TWO;

	    if (cell.getState() == State.EMPTY) {
		cell.setState(turn);
		cell.setImg(mPlayers[mTurn].getmImage());
		mCellAdapter.notifyDataSetChanged();

		int row = getWinningPosition(turn);
		if (row > -1) {
		    mIsGameover = true;

		    int[][] positions = Constants.getPositions();
		    List<Integer> pos = new ArrayList<Integer>();
		    pos.add(positions[row][0]);
		    pos.add(positions[row][1]);
		    pos.add(positions[row][2]);
		    highlightPosition(pos, R.color.blue_light);

		    String msg = getString(mPlayers[mTurn].getmName()) + " wins!";
		    Toast.makeText(GameActivity.this, msg, Toast.LENGTH_LONG).show();
		} else if (isDraw()) {
		    mIsGameover = true;
		    String msg = "Draw!!";
		    highlightPosition(getPositionFor(State.PLAYER_ONE), R.color.blue_dark);
		    highlightPosition(getPositionFor(State.PLAYER_TWO), R.color.red_dark);
		    Toast.makeText(GameActivity.this, msg, Toast.LENGTH_LONG).show();
		} else {
		    mTurn = (mTurn + 1) % 2;
		}
	    }
	}
    };
}
