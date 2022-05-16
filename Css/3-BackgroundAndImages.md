# Background and Images

## Background Image Related Properties

- `background-image`: Can be a `url` function or filepath.
- `background-size`: Max size of the image. If the image is smaller than the element's size, it will repeat by default. If you only provide one value, the aspect ratio will be maintained. If you provide 2 values, the width and height will be set (these values could be of different types, like % and px). **Note:** If you want to fill out the element with the image, the `cover` value is the best one to use, rather than `100%`. It will determine how best to fill out the element (for example zoom in if the image is too small). If you want to ensure the entire image is shown, use `contain`.
- `background-repeat`: Use `no-repeat` to turn off default behavior. Can do more controls, like only repeat on x or y axis.
- `background-position`: The offset of the background to the containing element. You can also use values like percentages,`center` or even `left center` (these control the alignment of the image and what gets cropped).

## Images

- This is where you use the `<img>` tag to add images to the document (not the `background-image` CSS property)..
- By default, the height and width of the image will override the dimensions of the containing element.
- You can override the default behavior by targeting the image and setting its dimensions, If you set a value such as `100%`, so that the image scales up to the full size of the containing element, the element needs to be an `inline-block`.
- Image tags have less flexibility for styling, however they are better for a11y. Use `background-image` if you want more options, but its best reserved for actual backgrounds.
- The downside of using `background-image` is that the image itself is not an HTML element that is part of the document flow.

## The Filter Property

- Allows you to change the look of an element.
- Examples include: opacity, grayscale, blur, contrast, etc.
- To see the complete list of options, visit the MDN: https://developer.mozilla.org/en-US/docs/Web/CSS/filter
- Note that IE does not support this.
