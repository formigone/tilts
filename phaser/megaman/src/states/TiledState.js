var mm = require('./../sprites/mm');

var TiledState = function(){
    this.hero;
};

TiledState.prototype = {
    preload: function(){
        this.load.tilemap('map', '/res/mm3-wily-002.json', null, Phaser.Tilemap.TILED_JSON);
        this.load.image('tileset', '/img/wily-mm3-002-atlas.png');
        mm.preload(this.game);
    },
    create: function(){
        var map = this.game.add.tilemap('map', 32, 32);
        var physics;
        var layer;
        var mapBods;

        this.game.physics.startSystem(Phaser.Physics.P2JS);
        physics = this.game.physics.p2;
        physics.gravity.y = 500;
        physics.restitution = 0.0;

        map.addTilesetImage('mm3-wily-02', 'tileset');
        map.createLayer('Background');

        // TODO: Is this necessary? Adding this layer doesn't seem to put it in Phaser's layers::location
        // @sampleMap https://raw.githubusercontent.com/photonstorm/phaser-examples/master/examples/assets/tilemaps/maps/collision_test.json
        map.createLayer('ObjLayer');
        layer = map.createLayer('Foreground');
        layer.resizeWorld();
        map.setCollisionBetween(1, 10);
        mapBods = physics.convertTilemap(map, 'ObjLayer');
        console.log(mapBods);

        this.hero = mm.get(this.game, 32, 0);
        physics.enable(this.hero);
        this.hero.body.fixedRotation = true;
        this.game.camera.follow(this.hero);

        this.game.physics.p2.setBoundsToWorld(true, true, true, true, false);
    },
    update: function(){
        if (this.game.input.keyboard.isDown(Phaser.Keyboard.RIGHT)) {
            this.hero.animations.play(this.hero.heroState.runningRight);
            this.hero.body.velocity.x = 75;
        } else if (this.game.input.keyboard.isDown(Phaser.Keyboard.LEFT)) {
            this.hero.body.velocity.x = -75;
        } else {
            this.hero.animations.play(this.hero.heroState.standingRight);
        }

        if (this.game.input.keyboard.isDown(Phaser.Keyboard.SPACEBAR)) {
            this.hero.animations.play(this.hero.heroState.jumpingRight);
            this.hero.body.velocity.y = -200;
        }
    }
};

module.exports = TiledState;
