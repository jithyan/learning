import _ from 'lodash';
import jsonPlaceholder from '../apis/jsonPlaceholder';

export const fetchPostsAndUsers = () => async (dispatch, getState) => {
        await dispatch(fetchPosts());
        const userIds = _.uniq(_.map(getState().posts, 'userId'))
        
        userIds.forEach(id => dispatch(fetchUser(id)));

/* More compact refactor:
        _.chain(getState().posts)
                .map('userId')
                .uniq()
                .forEach(id => dispatch(fetchUser(id)))
                .value() //basically execute()
 */
};

export const fetchPosts = () => async (dispatch) => {
        const response = await jsonPlaceholder.get('/posts');

        dispatch({ type: 'FETCH_POSTS', payload: response.data });
};

export const fetchUser = (id) => async dispatch => {
        const response = await jsonPlaceholder.get(`/users/${id}`);

        dispatch({ type: 'FETCH_USER', payload: response.data });
};

/*
import _ from lodash;

export const fetchUser = id => dispatch => _fetchUser(id, dispatch);

//Underscore is convention for private functions you shouldn't mess with
const _fetchUser = _.memoize(async (id, dispatch) => {
        const response = await jsonPlaceholder.get(`/users/${id}`);

        dispatch({type: 'FETCH_USER', payload: response.data});
});
*/