# Testing Tips

- Jest runs tests in JestDOM, which is a simulated browser environment. It does not support the entire browser API, such as making AJAX requests.
- At a basic level, you can always render React components with ReactDOM and conduct tests on it, but it's easier if you use the Enzyme library.
- Enzyme manages the rendering for you, and provides an API for querying components. All react components are wrapped in a ReactWrapper.
- To render components with Enzyme, you have 3 choices:

  1. `mount` for full DOM rendering (recommended as it's more realistic).
  2. `shallow` for only a partial render at the root level.
  3. `render` for static html rendering.

- Use `afterAll` or `afterEach` for cleanup/unmounting.
- Use `beforeAll` or `beforeEach` for setup.
- Call `wrapper.unmount()` after every test that uses full dom rendering.
- Use `describe` to scope variables to a bunch of tests.

- You can use CSS selectors to narrow down nodes.
- You can use `findWhere` like a filter function on all the nodes in a subset of results.

- If components have dependencies, you wrap the components with another component that provides those dependencies, like a redux store or context.

- When you find a node, it's not recommended to use the `text()` method to find the test display. Instead call `render()` on the node, and then access it's `text()` method. When you call `render()` you can invoke Cheerio queries - check the Cheerio JS documentation for how to use it.

- Use the `simulate` function to simulate events on nodes - 'change' for select and text boxes, 'click' for mouse clicks.
- When simulating select or textboxes, you need to pass in data using the following format: `{target: {value: 'test'}}`
- **Any state changes to a component, will require you to call `wrapper.update()`, for the component to re-render.**

- You can access component props by calling `wrapper.prop('propName')`.

## Mocking network requests

- You can't do network requests with JestDOM.
- If you're using Axios, you can use **Moxios** to mock it in Jest tests.
- In `beforeEach(() => moxios.install())`
- Then `moxios.stubRequest('http://www.google.com', {status: 200, response: {result: 'success'}})`

> But this alone will not allow you to make network requests!

- As these requests take time, your unit test will finish before it completes!
- One workaround is to use the `done` callback, which is passed into every `test` function:

```javascript
it("should work", done => {
  const wrapper = mount(<SomeComponent />);
  setInterval(() => {
    expect(wrapper.find(".comment").length).toEqual(500);
    done();
  }, 100);
});
```

_Jest won't complete the unit test until done is called!_

- However the problem with the above approach is that it setTimeout intervals are not precise and you don't want to arbitrarily slow down your tests.
- Instead, use the `moxios.wait` function, as so:

```javascript
moxios.wait(() => {
  expect(wrapper.length).toEqual(1);
  done();
  wrapper.unmount();
});
```
