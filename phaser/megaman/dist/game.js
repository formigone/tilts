!function n(i,t,g){function a(s,h){if(!t[s]){if(!i[s]){var R="function"==typeof require&&require;if(!h&&R)return R(s,!0);if(d)return d(s,!0);var e=new Error("Cannot find module '"+s+"'");throw e.code="MODULE_NOT_FOUND",e}var r=t[s]={exports:{}};i[s][0].call(r.exports,function(n){var t=i[s][1][n];return a(t?t:n)},r,r.exports,n,i,t,g)}return t[s].exports}for(var d="function"==typeof require&&require,s=0;s<g.length;s++)a(g[s]);return a}({1:[function(n,i,t){(function(n){function i(){R.load.atlasJSONHash("mm","/img/megaman.gif","/res/megaman.json")}function t(){a=R.add.sprite(s/2,h/2,"mm"),a.anchor.set(.5,.5),a.animations.add(r.standingRight,["standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRight","standingRightBlink"],16,!0,!1),a.animations.add(r.runningRight,["runningRight0","runningRight1","runningRight2"],10,!0,!1),a.animations.add(r.jumpingRight,["jumpingRight"],1,!0,!1)}function g(){R.input.keyboard.isDown(d.Keyboard.RIGHT)?(a.animations.play(r.runningRight),e="right"):a.animations.play(r.standingRight),R.input.keyboard.isDown(d.Keyboard.SPACEBAR)&&a.animations.play(r.jumpingRight)}var a,d="undefined"!=typeof window?window.Phaser:"undefined"!=typeof n?n.Phaser:null,s=800,h=450,R=new d.Game(s,h,d.AUTO,null,{preload:i,create:t,update:g}),e="right",r={standingRight:"standingRight",runningRight:"runningRight",jumpingRight:"jumpingRight",standingLeft:"standingLeft",runningLeft:"runningLeft",jumpingLeft:"jumpingLeft"}}).call(this,"undefined"!=typeof global?global:"undefined"!=typeof self?self:"undefined"!=typeof window?window:{})},{}]},{},[1]);
//# sourceMappingURL=game.js.map