// Why is this called index.js?
// Because when another file imports this, you only need
// to specify the folder name and the index.js file will
// be imported by default.
// The is done by webpack.

export const selectSong = (song) => {
    return {
        type: 'SONG_SELECTED',
        payload: song
    };
};
//note we're using named exports, instead of export default
//this is because we may have multiple actions to export.

