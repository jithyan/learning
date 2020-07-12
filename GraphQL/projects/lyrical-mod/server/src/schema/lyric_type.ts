import mongoose from "mongoose";
import {
  GraphQLObjectType,
  GraphQLList,
  GraphQLID,
  GraphQLInt,
  GraphQLString,
} from "graphql";

const Lyric = mongoose.model("lyric");

const LyricType = new GraphQLObjectType({
  name: "LyricType",
  fields: () => ({
    id: { type: GraphQLID },
    likes: { type: GraphQLInt },
    content: { type: GraphQLString },
    song: {
      type: require("./song_type"),
      resolve(parentValue) {
        return Lyric.findById(parentValue)
          .populate("song")
          .then((lyric: any) => {
            console.log(lyric);
            return lyric.song;
          });
      },
    },
  }),
});

export default LyricType;
