(function e(t,n,r){function s(o,u){if(!n[o]){if(!t[o]){var a=typeof require=="function"&&require;if(!u&&a)return a(o,!0);if(i)return i(o,!0);var f=new Error("Cannot find module '"+o+"'");throw f.code="MODULE_NOT_FOUND",f}var l=n[o]={exports:{}};t[o][0].call(l.exports,function(e){var n=t[o][1][e];return s(n?n:e)},l,l.exports,e,t,n,r)}return n[o].exports}var i=typeof require=="function"&&require;for(var o=0;o<r.length;o++)s(r[o]);return s})({1:[function(require,module,exports){
var game = new Phaser.Game(800, 600, Phaser.AUTO, null, {
    preload: preload,
    create: create,
});

function preload() {
    game.load.image('mm', '/img/x-helmet.png');
}

var sprite;
var bmd;

function create() {
    game.physics.startSystem(Phaser.Physics.P2JS);

    bmd = game.add.bitmapData(800, 600);

    sprite = game.add.sprite(400, 0, 'mm');

    game.physics.p2.enable(sprite);
    game.physics.p2.gravity.y = 800;
    game.physics.p2.restitution  = 0.0;

    sprite.body.fixedRotation = true;
    sprite.body.mass = 1;

    game.input.onDown.add(launch, this);
}

function launch() {
    if (game.input.x < sprite.x) {
        sprite.body.velocity.x = -50;
    } else {
        sprite.body.velocity.x = 50;
    }

    sprite.body.velocity.y = -400;
}

},{}]},{},[1]);
