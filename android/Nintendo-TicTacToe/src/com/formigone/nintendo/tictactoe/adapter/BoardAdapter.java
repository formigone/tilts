package com.formigone.nintendo.tictactoe.adapter;

import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.formigone.nintendo.tictactoe.model.Cell;

public class BoardAdapter extends BaseAdapter {
    protected List<Cell> mCells;

    public BoardAdapter(List<Cell> mCells) {
	super();
	this.mCells = mCells;
    }

    @Override
    public int getCount() {
	return mCells.size();
    }

    @Override
    public Object getItem(int position) {
	return mCells.get(position);
    }

    @Override
    public long getItemId(int position) {
	return mCells.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
	Cell cell = (Cell) getItem(position);

	if (convertView == null) {
	    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
	    convertView = inflater.inflate(cell.getLayout(), null);
	}
	
	cell.fill(convertView);

	return convertView;
    }
}
