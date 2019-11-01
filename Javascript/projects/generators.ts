const businessAnalystTeam = {
  lead: "CM",
  analyst: "PL",
  size: 2,
  *[Symbol.iterator]() {
    yield this.lead;
    yield this.analyst;
  }
};

const testingTeam = {
  lead: "PH",
  tester: "GM",
  size: 2,
  *[Symbol.iterator]() {
    yield this.lead;
    yield this.tester;
  }
};

const engineeringTeam = {
  testingTeam,
  lead: "RS",
  senior: "JG",
  junior: "JN",
  size: 3,
  *[Symbol.iterator]() {
    yield this.lead;
    yield this.senior;
    yield this.junior;
    yield* this.testingTeam;
  }
};

const anzTeam = {
  engineeringTeam,
  businessAnalystTeam,
  manager: "DO",
  rating: "A",
  size: 7,
  *[Symbol.iterator]() {
    yield this.manager;
    yield* this.engineeringTeam;
    yield* this.businessAnalystTeam;
  }
};

const memberNames = [];
for (const member of anzTeam) {
  memberNames.push(member);
}

console.log(`The members of the ANZ squad are: ${JSON.stringify(memberNames)}`);

class Post {
  content: string;
  childposts: Post[];

  constructor(content: string, childposts: Post[]) {
    this.content = content;
    this.childposts = childposts;
  }

  //@ts-ignore
  *[Symbol.iterator]() {
    yield this.content;
    for (const child of this.childposts) {
      yield* child;
    }
  }
}
const children: Post[] = [
  new Post("good comment", [
    new Post("totally agree", [new Post("completely disagree", [])])
  ]),
  new Post("Bad Coment", []),
  new Post("Meh", [new Post("WAAAAAH!", []), new Post("You're a NAZI", [])])
];

const topComment: Post = new Post("Best comment", children);

const allComments = [];
for (const comment of topComment) {
  allComments.push(comment);
}

console.log(`All comments are: ${JSON.stringify(allComments)}`);
