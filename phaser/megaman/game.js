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
