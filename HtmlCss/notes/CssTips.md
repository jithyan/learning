# CSS Tips

- Use Pseudo Classes to Change Style on Change in State

> `:hover` - When the mouse hovers over.

- Giving a Circular Border to an Image

```css
img {
  border-radius: 100%;
}
```

- Give elements multiple classes to mix and match styles.

```html
<html>
  <style>
    .important {
      background-color: red;
    }

    .circular {
      border-radius: 100%;
    }
  </style>
  <body>
    <img class="important circular" href="/img/i.png" />
  </body>
</html>
```

- Circle shorthand:

  - You start from the top and go clockwise, applies to any property that has 4 sides.
  - If you just give two values, it meanse `top+bottom left+right`
  - If you just give one value, it means _all sides_.
  - If you give give three values, it means `top right+left bottom`

- To hide an element:
  - If you want to remove it from the flow of the document itself, use: `display: none;`
  - If you want it to make it invisible, but still take up space and keep its position: `visibility: none;`
