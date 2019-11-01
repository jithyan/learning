import React, {useState} from 'react';
import ResourceList from './ResourceList';
import UserList from './UserList';

const App = () => {
   const [resource, setResource] = useState('posts'); //Array destructuring

   return (
      <div>
         <UserList />
         <button onClick={() => setResource('posts')}>
            Posts
         </button>
         <button onClick={() => setResource('todos')}>
            To Dos
         </button>
         <ResourceList resource={resource}/>
      </div>
   );
};

export default App;