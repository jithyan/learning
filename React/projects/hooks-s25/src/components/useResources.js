import {useState, useEffect} from 'react';
import axios from 'axios';

//We've extracted hook logic to a different function - therefore reuseable! :)
const useResources = (resource) => {
   const [resources, setResources] = useState([]);

   const fetchResource = async (resource) => {
      const response = await axios.get(`http://jsonplaceholder.typicode.com/${resource}`);
      setResources(response.data);
   };

   useEffect(() => {fetchResource(resource)}, [resource]);
   //The second argument is an array
   //In the subsequent calls to useEffect have different values in its 2nd argument,
   //then the function in the first argument is called - thereby only executing it
   //when necessary!
   //In other words, unecessary updates are blocked.
   //If you omit the second argument however, it will always be called!
   //If you pass in only an empty array, it's the same as componentDidMount (only called once).

   return resources;
}

export default useResources;