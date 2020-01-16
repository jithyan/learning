# Advanced Html

## Structuring Content

### Pure Containers

These allow you to divide and structure your content, and are inherently useless without CSS.
_These should be used when there is no appropriate semantic container._

**\<div\>**

- A generic container for flow content.
- It's default styling is `display: block`.

**\<span\>**

- A generic inline container for phrasing content, or grouping elements for styling.
- It's default styling is `display: inline`.

### Semantic Containers

**\<article\>**

- A self-contained component of a document, that is re-useable or distributable.
- Examples: a blog entry, a forum post and a newspaper article.

**\<nav\>**

- Represents a section of a page whose sole purpose is to provide links.
- Examples: a menu, a table of contents and indexes.

**\<section\>**

- Represents a standalone section — which doesn't have a more specific semantic element to represent it — contained within an HTML document. Typically, but not always, sections have a heading.

**\<main\>**

- Represents the dominant content of the `<body>` of a document. The main content area consists of content that is directly related to or expands upon the central topic of a document, or the central functionality of an application.
- A document mustn't have more than one `<main>` element that doesn't have the hidden attribute specified.

**\<hgroup\>**

- Groups a set of h1 to h6 elements.

Example:

```html
<hgroup>
  <h1>Calculus I</h1>
  <h2>Fundamentals</h2>
</hgroup>
```

**\<aside\>**

- Represents a portion of a document whose content is only indirectly related to the document's main content.
- Asides are frequently presented as sidebars or call-out boxes.
