# React Notes

## The Virtual DOM

* The DOM represents all the UI elements of a page in the browser.
* Updates to the DOM are expensive as many processes take place such as recalculating CSS for the parent and child elements and updating the render tree.
* React maintains a 'light-weight' representation of the DOM, known as a Virtual DOM.
* React detects state changes, then updates its virtual DOM. It then applies a 'diffing' algorithm which compares the previous version of the virtual DOM with the new version. This allows React to know which specific DOM nodes actually require an update, and only update those in the real DOM.
* The details of DOM manipulation is abstracted from the developer, giving them an easier experience.
* In short, React achieves greater performance by:
   - Using the Virtual DOM to minimize which real DOM elements get updated.
   - Sending updates to the real DOM in batches.

### How React Detects and Handles Updates

> ReactJS uses observable’s to find the modified components. Whenever setState() method is called on any component, ReactJS makes that component dirty and re-renders it.

> Whenever setState() method is called, ReactJS creates the whole Virtual DOM from scratch. Creating a whole tree is very fast so it does not affect the performance. At any given time, ReactJS maintains two virtual DOM, one with the updated state Virtual DOM and other with the previous state Virtual DOM.

### How the render() Function Works

> render() function is the point of entry where the tree of React elements are created. When a state or prop within the component is updated, the render() will return a different tree of React elements. If you use setState() within the component, React immediately detects the state change and re-renders the component.

> React then figures out how to efficiently update the UI to match the most recent tree changes.

> This is when React updates its virtual DOM first and updates only the object that have changed in the real DOM.


## React Components, Elements, and Instances

* In React, an element is a plain object describing a component instance or DOM node and its desired properties.
* An element is not an actual instance. Rather, it is a way to tell React what you want to see on the screen. You can’t call any methods on the element. It’s just an immutable description object with two fields: `type: (string | ReactClass)` and `props: Object1`.
* When an element’s `type` is a string, it represents a DOM node with that tag name, and props correspond to its attributes.

For example:

```javascript
{
  type: 'button',
  props: {
    className: 'button button-blue',
    children: {
      type: 'b',
      props: {
        children: 'OK!'
      }
    }
  }
}
```

> React elements are easy to traverse, don’t need to be parsed, and of course they are much lighter than the actual DOM elements — they’re just objects!

> An element describing a component is also an element, just like an element describing the DOM node. They can be nested and mixed with each other.

This feature allows you to define a **DangerButton** `component` that is of `type` **Button** without worrying whether **Button** renders to the DOM as a `<button>` or `<div>`:

```javascript
```

You can mix and match DOM and component elements in a single element tree:

```javascript
const DeleteAccount = () => ({
  type: 'div',
  props: {
    children: [{
      type: 'p',
      props: {
        children: 'Are you sure?'
      }
    }, {
      type: DangerButton,
      props: {
        children: 'Yep'
      }
    }, {
      type: Button,
      props: {
        color: 'blue',
        children: 'Cancel'
      }
   }]
});
```

Or if you prefer JSX:

```javascript
const DeleteAccount = () => (
  <div>
    <p>Are you sure?</p>
    <DangerButton>Yep</DangerButton>
    <Button color='blue'>Cancel</Button>
  </div>
);
```
