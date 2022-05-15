# Basics

## Box Sizing

- By default, a lot of elements use `content-box` for box sizing. This means that
  only the content of an element is considered for its width/height.
- `border-box` is more useful than `content-box` as it includes the border and padding of the element.
- It's recommended to use `border-box` instead of `content-box`, by including the following code:

```css
* {
  box-sizing: border-box;
}
```

## Float

- No longer commonly used.
- Essentially takes an element out of the document flow, and elements that follow it will "float" around it.
- Useful for positioning images so that text float around it.

## Hiding elements

- If you want to hide an element but preserve its position in the layout, use `visibility: hidden`.
- If you want to hide an element and remove it's position from the layout, use `display: none`.
- Both preserve the element in the DOM.

## Psuedo classes and elements

- **Psuedo classes** defines the style of the _state_ of an element. Accessed as: `:className`.
- **Psuedo elements** defines the style of a _specific part_ of an element. Accessed as: `:: elementName`.

## More on selectors

### Increasing element specificity

- You can increase the specificity of a selector by targetting the element and the class.

```css
a.active {
  background: white;
}
```

- The above example selects all anchor tags (`<a>`) that have the `active` class.
- The difference between the above and using a combinator, is that a combinator targets nested elements.

### Combining independent selectors

- You can group independent selectors with the same style, by separting them with a comma. Eg:

```css
.navbar-default a:active,
.header-main a:hover {
  color: white;
}
```

## General Element Styling

- The spaces between elements inserted by your editor can affect the layout of `inline-block` elements! Removing the spaces would fix the issue, or taking that space into account and removing it via CSS.
- Use `vertical-align: middle` to align elements on the y axis.
- Adding a **shadow** to an element. - use `box-shadow`. The style `box-shadow: 2px 3px 4px 5px rgba(0, 0, 0, 0.5)`, means that the shadow will be 2px off on the x-axis, 3px off on the y-axis, 4px of blur and 5px of spread. The blur and spread can be omitted, but will give a very sharp shadow. A color function is used. An `rgb(0,0,0)` is black. The fourth argument is the transparency (alpha channel). `0.5` means 50%.
- **Outlines:** This not part of the box model. In order to change the outline, set the property via the `:focus` pseudo class. E.g. `.button:focus { outline: none; }`
- To **center** an element horizontally, use `margin: auto`.

## Misc

- You can remove the styling of lists by using `list-style: none`.
- If you want to remove the underline in a link, use `text-decoration: none;`.
- You can use the calc function like this: `calc(100% - 49px)`. The spaces in the function are important.
- The value `inherit` for a property, ensures that a value is inherited rather than using browser defaults.
- You can change the cursor on an element, by using `cursor`. E.g. `cursor: pointer`
- To get a perfect **circle**, use `border-radius: 50%`.
- To add an image using CSS, you use the `background` style and call the `url` function. Pass either a local file path or remote URL as a string.

```css
#main {
  background: url("https://dog.com/image.png");
}
```
