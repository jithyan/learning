# Why GraphQL

To understand why, we need to know the current popular method, RESTful routing.

## RESTful Basics

![restfulrouting](./img/restfulrouting.PNG)

### Basic manipulation of records of a single entity

![basicmethods](./img/basicmethods.PNG)

### Manipulating associated entities

![relatedentities](./img/relatedentities.PNG)

## Shortcomings of REST

### Deeply nested entities

#### Example UI

![example-ui](./img/example-ui.PNG)

#### Example ER

![example-er](./img/example-er.PNG)

#### Example Relationships

![example-relationships](./img/example-relationships.PNG)

### How do you find the companies and positions of a user's friends?

What kind of RESTful URL look like to answer the above question?

![example-rest-challenge](./img/example-rest-challenge.PNG)

#### Option 1

1. Get the list of user's friends at /user/23/friends
2. Make a separate query for each friend, to get all their details - which will include the `company` and `position`

![example-opt1](./img/example-opt1.PNG)

**PROBLEM:** It can be a lot of HTTP requests! This can be very expensive!

**BENEFIT**: Simple and intuitive, obeys RESTful conventions.

#### Option 2

1. _Without violating RESTful conventions_, Expose a URL that answers that specific question - it will be a URL with deeply nested entities

![example-opt2](./img/example-opt2.PNG)

**PROBLEM:** You have to program that endpoint to answer that very specific question. If there are many questions that involve complex relationships,
that would mean an explosion of endpoints you have to manually code! The URL will also become very long!

#### Option 3

Break RESTful conventions, expose an endpoint that answers that specific question.

![example-opt3](./img/example-opt3.PNG)

**PROBLEM:** You've broken REST conventions, and still have the problem of option 2.

### Shortcoming of ALL RESTful endpoints

You generally end up OVER-serving the data you send to the client.
There's no way to only get the specific data you need.

In the example above, you just care about at most 3 fields - but you will probably get a tonne of fields related to users, companies and positions!
