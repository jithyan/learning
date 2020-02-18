import React from 'react';

const VideoDetail = ({video}) => {
    if (!video) {
        return <div>Loading</div>;
    }

    const videoSource = `https://www.youtube.com/embed/${video.id.videoId}`
     
    return (
        <div>
            <div className="ui embed">
                <iframe title="Video Player" src={videoSource} />
            </div>
            <div className="ui segment">
                <h4 className="ui header">{video.snippet.title}</h4>
                <p></p>
            </div>
        </div>
    );
};

export default VideoDetail;

