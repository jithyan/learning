A single line will have text.

Leave an empty line to create a new paragraph

Multiple lines will
be merged into a single line,
Github breaks this rule.

# Start a line with a # for a header
No empty line needed here

## Header 2
### Header 3
#### Header 4
##### Header 5
###### Header 6
####### No header 7

> This is a quote

> It can extent to multiple lines,
> or be merged like normal markdown

*This is italic*

_This is also italic_

**This is bold**

__This is also bold__

**Mix _and_ match as you like**

* This is a list
* It goes as far as you want
  * Two spaces lets you nest
    * You can nest as far down as you want

Make sure you give an empty line to end the list.

1. A numbered list is like this
1. Note that you don't have to do the numbering yourself
3. But you can if you want
  1. Nesting works here too
    * Even mixed nesting

You can activate `code blocks` with backticks, `_this can be useful_` for showing markdown

```Triple backticks will work
even if the lines go across multiple lines```

    Adding 4 spaces in front of a
    line will make it into a code block

You can add links easily too, google is found [here](http://www.google.com)

Images are like links ![google](https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png)

# Github specific

~~Github allows for mistakes~~

```
Starting a triple backtick with a newline
will make a code block as well```

You can also enable syntax highlighting by starting a block with the language name
```go
func hello() {
  fmt.Println("Hello World!")
}```

There | are | also
:----- | :---: | ----:
Tables|in | github
They| are |fancy

* [ ] Checkboxes are available for issues
* [x] And the wiki
