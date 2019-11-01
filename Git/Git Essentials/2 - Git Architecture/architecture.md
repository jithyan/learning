# Git Essentials - Architecture

* Git uses a 3 Tree Architecture, most other VCSs use 2 Tree Architecture.

![2Tree](./2tree.PNG)

* We call them *trees* because they represent a file structure.

![3Tree](./3tree.PNG)

* The power of the Staging Index is that if you have made changes to 10 files, but you only want to **commit 5** of them as *one changeset*, you add the 5 to the staging index and then commit.

* A Git **changeset** is a *snapshot* of the changes made, not anything to do with files or versions of files.

* Unlike other VCSs, Git checks the integrity of every commit:

![Checksum](./checksum.PNG)

* Every commit is attached with a checksum, and a pointer to its parent (predecessor commit):

![Checksum](./refercommits.PNG)

 * Git maintains a variable called HEAD:

 ![Head](./head.PNG)

 