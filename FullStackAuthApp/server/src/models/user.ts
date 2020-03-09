import mongoose, { Mongoose } from "mongoose";
import bcrypt from "bcrypt-nodejs";

const Schema = mongoose.Schema;

export interface IUser extends mongoose.Document {
  id?: string;
  password: string;
  email: string;
  comparePassword: (
    candidatePassword: string,
    callback: (arg1: any, arg2?: boolean) => void
  ) => void;
}
// Define our model
const userSchema = new Schema<IUser>({
  email: { type: String, unique: true, lowercase: true },
  password: String
});

userSchema.methods.comparePassword = function(candidatePassword, callback) {
  bcrypt.compare(candidatePassword, this.password, function(err, isMatch) {
    if (err) {
      return callback(err);
    }
    callback(null, isMatch);
  });
};

//On Save Hook, encrypt password
// a "hook" that runs before saving the password
userSchema.pre("save", async function(next) {
  //get access to the user model
  const user = (this as unknown) as IUser;

  bcrypt.genSalt(10, function(err, salt) {
    if (err) {
      return next(err);
    }
    bcrypt.hash(user.password, salt, null, function(err, hash) {
      if (err) {
        return next(err);
      } else {
        user.password = hash;
        return next();
      }
    });
  });
});

// Create the model class
const modelClass = mongoose.model<IUser>("user", userSchema);

// Export the model
export default modelClass;
