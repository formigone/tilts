package com.formigone.nintendo.tictactoe.model;

import android.view.View;

public interface Fillable {
    public static abstract class ViewHandler{}
    
    public ViewHandler getHandler(View convertView);
    public void fill(View view);
}
