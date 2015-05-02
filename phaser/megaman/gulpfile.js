var gulp = require('gulp');
var browserify = require('browserify');
var uglify = require('gulp-uglify');
var source = require('vinyl-source-stream');
var buffer = require('vinyl-buffer');
var sourcemaps = require('gulp-sourcemaps');
var gutil = require('gulp-util');

var FILES = {
    game: './test.js',
    out: 'game.js',
    outDir: './dist/'
};

gulp.task('quick-bundle', function () {
    return browserify({
        entries: FILES.game,
        debug: false
    })
        .bundle()
        .pipe(source(FILES.out))
        .pipe(buffer())
        .pipe(gulp.dest(FILES.outDir));
});

gulp.task('uglify-bundle', function () {
    var b = browserify({
        entries: FILES.game,
        debug: false
    });

    return b.bundle()
        .pipe(source(FILES.out))
        .pipe(buffer())
        .pipe(sourcemaps.init({
            loadMaps: true
        }))
        .pipe(uglify({
            compress: true,
            warnings: true,
            strict: true,
            dead_code: true,
            drop_debugger: true,
            join_vars: true
        }))
        .pipe(sourcemaps.write('.'))
        .pipe(gulp.dest(FILES.outDir));
});

gulp.task('default', ['quick-bundle']);
gulp.task('build', ['uglify-bundle']);
