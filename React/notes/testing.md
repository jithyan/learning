# Testing Tips

- Call `wrapper.unmount()` after every test that uses full dom rendering.
- You can use CSS selectors to narrow down nodes.
- You can use `findWhere` like a filter function on all the nodes in a subset of results.
- Use describe to scope variables to a bunch of tests.
- Use `afterAll` or `afterEach` for cleanup/unmounting.
- Use `beforeAll` or `beforeEach` for setup.
- If components have dependencies, you wrap the components with another component that provides those dependencies, like a redux store or context.
