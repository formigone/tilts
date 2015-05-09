(function e(t,n,r){function s(o,u){if(!n[o]){if(!t[o]){var a=typeof require=="function"&&require;if(!u&&a)return a(o,!0);if(i)return i(o,!0);var f=new Error("Cannot find module '"+o+"'");throw f.code="MODULE_NOT_FOUND",f}var l=n[o]={exports:{}};t[o][0].call(l.exports,function(e){var n=t[o][1][e];return s(n?n:e)},l,l.exports,e,t,n,r)}return n[o].exports}var i=typeof require=="function"&&require;for(var o=0;o<r.length;o++)s(r[o]);return s})({1:[function(require,module,exports){
var states = {
    tiled: {
        id: 'Tiled',
        src: require('./src/states/TiledState')
    }
};

var WIDTH = 400;
var HEIGHT = 300;

var game = new Phaser.Game(WIDTH, HEIGHT, Phaser.AUTO, null);
game.state.add(states.tiled.id, states.tiled.src);

game.state.start(states.tiled.id);

},{"./src/states/TiledState":3}],2:[function(require,module,exports){
module.exports = {
    preload: function (game) {
        game.load.atlasJSONHash('mm', '/img/megaman.gif', '/res/megaman.json');
    },
    get: function (game, x, y) {
        var heroLastDir = 'right';
        var heroState = {
            standingRight: 'standingRight',
            runningRight: 'runningRight',
            jumpingRight: 'jumpingRight',

            standingLeft: 'standingLeft',
            runningLeft: 'runningLeft',
            jumpingLeft: 'jumpingLeft'
        };

        var hero = game.add.sprite(x, y, 'mm');
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

        return hero;
    }
};

},{}],3:[function(require,module,exports){
var mm = require('./../sprites/mm');

var TiledState = function(){
    this.map;
    this.hero;
    this.layerBg;
    this.layerFg;
};

TiledState.prototype = {
    preload: function(){
        this.load.tilemap('map', '/res/mm3-wily-002.json', null, Phaser.Tilemap.TILED_JSON);
        this.load.image('tileset', '/img/wily-mm3-002-atlas.png');
        mm.preload(this.game);
    },
    create: function(){
        this.map = this.game.add.tilemap('map', 32, 32);
        this.map.addTilesetImage('mm3-wily-02', 'tileset');

        this.layerBg = this.map.createLayer('Background');
        this.layerFg = this.map.createLayer('Foreground');
        this.layerBg.resizeWorld();

        this.hero = mm.get(this.game, 32, 32);
        this.game.camera.follow(this.hero);
    },
    update: function(){
    }
};

module.exports = TiledState;

},{"./../sprites/mm":2}]},{},[1]);
