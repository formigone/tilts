package com.formigone.nintendo.tictactoe;

import java.util.HashMap;

public class Constants {
    private final static int[][] winningPositions = new int[][] {
	{ 0, 1, 2 },
	{ 3, 4, 5 },
	{ 6, 7, 8 },
	{ 0, 3, 6 },
	{ 1, 4, 7 },
	{ 2, 5, 8 },
	{ 0, 4, 8 },
	{ 2, 4, 6 }
    };
    
    public static int[][] getPositions() {
	return winningPositions;
    }

    private static HashMap<Integer, int[]> systems = null;
    
    public static HashMap<Integer, int[]> getSystems() {
	if (systems == null) {
	    systems = new HashMap<Integer, int[]>();
	    systems.put(R.string.player_ds, new int[] {
		    R.string.player_ds,
		    R.drawable.controller_ds, 
		    R.color.ds_default,
		    R.color.ds_accent });
	    systems.put(R.string.player_famicom, new int[] {
		    R.string.player_famicom,
		    R.drawable.controller_famicom, 
		    R.color.famicom_default,
		    R.color.famicom_accent });
	    systems.put(R.string.player_gba, new int[] {
		    R.string.player_gba,
		    R.drawable.controller_gba, 
		    R.color.gba_default,
		    R.color.gba_accent });
	    systems.put(R.string.player_gbm, new int[] {
		    R.string.player_gbm,
		    R.drawable.controller_gbm, 
		    R.color.gbm_default,
		    R.color.gbm_accent });
	    systems.put(R.string.player_gcn, new int[] {
		    R.string.player_gcn,
		    R.drawable.controller_gcn, 
		    R.color.gcn_default,
		    R.color.gcn_accent });
	    systems.put(R.string.player_n64, new int[] {
		    R.string.player_n64,
		    R.drawable.controller_n64, 
		    R.color.n64_default,
		    R.color.n64_accent });
	    systems.put(R.string.player_nes, new int[] {
		    R.string.player_nes,
		    R.drawable.controller_nes, 
		    R.color.nes_default,
		    R.color.nes_accent });
	    systems.put(R.string.player_snes, new int[] {
		    R.string.player_snes,
		    R.drawable.controller_snes, 
		    R.color.snes_default,
		    R.color.snes_accent });
	    systems.put(R.string.player_wii, new int[] {
		    R.string.player_wii,
		    R.drawable.controller_wii, 
		    R.color.wii_default,
		    R.color.wii_accent });
	}
	return systems;
    }
}
