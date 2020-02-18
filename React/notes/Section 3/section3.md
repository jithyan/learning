# Section 3 - Communicating with Props

## L26

- Use semantic-ui for CSS boilerplate.
- Search for semantic-ui cdn, to look for the CSS files. Copy the link to the public hosted semantic-ui CSS file.
- In the index.html file, add a <link rel="stylesheet" href="link to semantic.min.css url"> within the header.

## L28

- We need image data for our website. The easiest way to do this is using Faker.js - a library that generates a vast array of fake data - customer data, credit card data as well as images!
- Go to the console and navigate to the root project directory. Then type `npm install --save faker`.
- `--save` indicates you want to save it into your project.
- The GitHub page for FakerJS shows what kind of fake data it can generate. To access fake image avatars in JSX, simply put `{faker.image.avatar()}`.
- Every time you refresh the page, a new avatar image would be generated.

## L30

![Component Tenents of React](./component-tenents-of-react.PNG)

Steps to create a reusable, configurable component (component names are in upper camel case):

![Creating a Component](./creating-components.PNG)

- To import components, you have to add an `export default <name>` to the end of the file you want to be imported.
- Then you can import the file using a relative file path i.e. `import MyFile from './MyFile'`

![Linking Components](./linking-components.PNG)

- When you want to refer to components in JSX, you don't need curly braces - you treat them like HTML tags!

![Importing Components](./import-component.PNG)

## L31

![Props](./props.PNG)

![Sending Props](./props-send.PNG)

![Props Parent to Child](./props-parent-to-child.PNG)

- For the child component to access the arguments passed to it, you need to define a single argument - by convention it will be called props.
- The parent will pass a JS object of key-value pairs, of all the arguments passed to be passed to the child. E.g.:

(image props child)
![Props Child Access](./props-child-access.PNG)

## L38

- When you pass a component as an argument to another component in JSX (and not through attributes), the component will be passed into the 'props' object.
- The the component argument value would specifically turn up in the property 'children' in the 'props' object.

![Props Children](./props-children.PNG)