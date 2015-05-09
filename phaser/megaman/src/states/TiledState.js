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
