(function e(t,n,r){function s(o,u){if(!n[o]){if(!t[o]){var a=typeof require=="function"&&require;if(!u&&a)return a(o,!0);if(i)return i(o,!0);var f=new Error("Cannot find module '"+o+"'");throw f.code="MODULE_NOT_FOUND",f}var l=n[o]={exports:{}};t[o][0].call(l.exports,function(e){var n=t[o][1][e];return s(n?n:e)},l,l.exports,e,t,n,r)}return n[o].exports}var i=typeof require=="function"&&require;for(var o=0;o<r.length;o++)s(r[o]);return s})({1:[function(require,module,exports){
(function (global){
var Phaser = (typeof window !== "undefined" ? window.Phaser : typeof global !== "undefined" ? global.Phaser : null);

var WIDTH = 800;
var HEIGHT = 450;

var game = new Phaser.Game(WIDTH, HEIGHT, Phaser.AUTO, null, {preload: preload, create: create, update: update});

var hero;
var heroLastDir = 'right';
var heroState = {
    standingRight: 'standingRight',
    runningRight: 'runningRight',
    jumpingRight: 'jumpingRight',

    standingLeft: 'standingLeft',
    runningLeft: 'runningLeft',
    jumpingLeft: 'jumpingLeft'
};

function preload() {
    game.load.atlasJSONHash('mm', '/img/megaman.gif', '/res/megaman.json');
}

function create() {
    hero = game.add.sprite(WIDTH / 2, HEIGHT / 2, 'mm');
    hero.anchor.set(0.5, 0.5);

    hero.animations.add(heroState.standingRight, [
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRight',
        'standingRightBlink'
    ], 16, true, false);

    hero.animations.add(heroState.runningRight, [
        'runningRight0',
        'runningRight1',
        'runningRight2',
    ], 10, true, false);

    hero.animations.add(heroState.jumpingRight, [
        'jumpingRight'
    ], 1, true, false);
}

function update() {
    if (game.input.keyboard.isDown(Phaser.Keyboard.RIGHT)) {
        hero.animations.play(heroState.runningRight);
        heroLastDir = 'right';
//        } else if (game.input.keyboard.isDown(Phaser.Keyboard.LEFT)) {
//            hero.animations.play(heroState.runningLeft);
//            heroLastDir = 'left';
    } else {
        hero.animations.play(heroState.standingRight
        );
    }

    if (game.input.keyboard.isDown(Phaser.Keyboard.SPACEBAR)) {
        hero.animations.play(heroState.jumpingRight);
    }
}

}).call(this,typeof global !== "undefined" ? global : typeof self !== "undefined" ? self : typeof window !== "undefined" ? window : {})
},{}]},{},[1]);
