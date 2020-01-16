# Basic Html

## Boilerplate

Every HTML5 document will have the following boilerplate:

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>Jithya's Personal Site</title>
  </head>

  <body></body>
</html>
```

- `<!DOCTYPE html>` - this is the declaration that is an **HTML5** document. It's considerably less complex than the declaration in HTML4.
- `<head>` contains machine-readable information (metadata) about the document, like its title, scripts, and style sheets.
- `<meta>` represents metadata that cannot be represented by other HTML meta-related elements, like`<base>`, `<link>`, `<script>`, `<style>` or `<title>`.
  - The `charset` attribute defines the encoding of the document.
  - It is strongly recommended to define the character encoding. If a page's encoding is undefined, cross-scripting techniques are possible, such as the UTF-7 fallback cross-scripting technique.
  - This is synonymous with this pre-HTML5 code: `<meta http-equiv="Content-Type" content="text/html; charset=IANAcharset">`
- `<title>` displays text in the browser's title bar or a page's tab. It only contains text; tags within the element are ignored.
- There are _self-closing_ tags such as `<meta>`, `<hr>` and `<br>`.

## Basic Tags

- `<p>` - defines a grouped, block of text - i.e. a paragraph.
- `<em>` - _emphasis_. Marks text that is to be _stressed_. Visually equivalent to `<i>`, but it includes **semantic** meaning, and is _recommended_ over `<i>`.
- `<strong>` - _strong emphasis_. Visually equivalent to `<b>` but confers meaning as well.
- `<hr/>` - horizontal rule. Can be thickened with the `size` attribute.
- `<center>` - centers text.
- `<a>` - with its `href` attribute, creates a hyperlink to web pages, files, email addresses, locations in the same page, or anything else a URL can address. Content within each `<a>`should indicate the link's destination.
  - `download` attribute- Prompts the user to save the linked URL instead of navigating to it. Can be used with or without a value.
  - `href` attribute - The URL that the hyperlink points to. Links are not restricted to HTTP-based URLs.

**NOTE:** HTML5 is to confer meaning and structure, so use HTML5 tags that do that, and not older tags which may just affect stylisting elements.

## Tables

Represented by the `<table>` element, which must be closed.

### Basic Structure

Made up three basic sections:

- `<thead>` - signifies the header section of the table. Heading elements should go here.
- `<tbody>` - signifies the table body. Data elements should go here.
- `<tfoot>` - signifies the table footer.

The above sections are _optional_. But it is **best practice to use them**, especially when you use CSS for styling.

### Putting Data

- You don't specify columns in a table. Instead you specify rows, and every element in them.
- `<tr>` is a row element.
- `<td>` is a data element and must be in a `<tr>`. You can nest another `<table>` in `<td>`, but this _not recommended_.
- `<th>` is a header element (used like `<td>`), it should be in the `<thead>` section, enclosed by `<tr>`. It still can be used outside of `<thead>` but this isn't recommended.

### Deprecated

There are many attributes associated with table related elements, which must not be used, as they have been deprecated (most of them control visual style).

### Example

```html
<table>
  <thead>
    <tr>
      <th>First Name</th>
      <th>Last Name</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>Saddam</td>
      <td>Hussein</td>
    </tr>
    <tr>
      <td>Josef</td>
      <td>Stalin</td>
    </tr>
  </tbody>
</table>
```

## Basic Forms

### Structure

All forms will consist of:

- A parent `<form>` element that encloses:
  - A `<label>` element.
  - An `<input>` element.
  - You can use a `<textarea>` element for large textboxes.

### Example

```html
<form>
  <label>Your name</label>
  <input type="text" />
</form>
```

### The form element

Has three main attributes:

- `action` - What to do when the **submit** `input` type is clicked. It could be a redirect to another webpage, or even an e-mail (e.g.: "mailto:example@email.com")
- `method` - What HTTP method to perform form submission. `post`, `get` or `dialog` (which closes a dialog on submission). This can be overriden by the `formmethod` attribute of `<input type="submit">`.
- `enctype` - If the value of the method attribute is post, enctype is the MIME type of the form submission. Possible values: `application/x-www-form-urlencoded`, `multipart/form-data` or `text/plain`.

### The input element

The input element encompasses a wide variety of form controls. E.g. `type="email"` will perform simple e-mail regex validation. `type="password"` will mask password text.

Each of them is defined by their `type` attribute.

Visit the MDN for the complete list of controls.

The main attributes are:

- `name` - Identify the input control.
- `value` - the value of the control. By population this, you're setting a default.
- `type` - these are very diverse. From range controls, to date and color pickers.
