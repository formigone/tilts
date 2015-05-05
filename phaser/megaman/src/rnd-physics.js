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
