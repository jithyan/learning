# Positioning Elements

## The `position` property

- By default, all elements follow one after the other.
- The value of `position` for this default document flow is `static`.
- When you position an element outside of the document flow, you have 4 different options to move the element - top, bottom, left or right from their initial position in the document flow. When you specify in pixels where to position, what is it in relation to? This is known as the positioning context, and the element could be moved in relation to the element itself (e.g. move 20px from current position), the `viewport`, the `<body>` tag or any other element.
- The position properties `top`, `bottom`, `left`, and `right` will only take effect if the value of `position` is anything other than `static`.
- **`absolute`** position value means that the element's positioning context is the nearest ancestor who has a position set (that is, not the default of `static`),
- **`fixed`** position value means that the element's positioning context is the viewport.
- **`relative`** does not take the element out of the document flow. **The positioning context is the _element itself_**.

### The `sticky` value

- Browser support isn't great at the time of writing.
- It is like a hybrid of relative and fixed positioning.
- You need to specify a `top`, `left`, `bottom`, or `right` property. This will define the distance between the element and the **viewport**.
- When you scroll down, and the distance specified is reached, the element will become fixed UNTIL you scroll to the end of the parent element that holds the sticky element.

## The `overflow` property

- When you set `overflow:hidden`, if the child element overflows outside of its parent element, it will be hidden.

-

## Z-Index

- Controls on what "level" an element is on the z-axis. In other words, can an element be on top of another.
- The default value given to all elements is `auto` which is `0`.
- If you manually specify the z-index, it will be ignored if its `position` is `static`.
- If you want an element to be under other elements, you give it a lower `z-index` (like `-1`).
- The **stacking context** basically means the `z-index` of the parent elements will determine if their children will overlay another element with a different parent and `z-index`. Therefore in this scenario, simply giving a child element the highest z-index will not guarantee that it will be the top most element.
