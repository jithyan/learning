# Useful Commands

> go fmt

Will format the files in the folder into standardized format.

> go fmt ./...

Above syntax is unique to go.
It will format all the file from the current directory downwards.

> go run [filename]

Compiles and executes specified file, deleting any temp files/binaries.

> go build

for an exe:
Compiles/ build into an executable in the current folder.

for a package:
Compiles and then throws away binary (use to find errors).

> go install [filename] or \*.go
> You may have to set GOBIN to your workspace/bin dir.

Will build exe to your bin dir.

For a package, put it into /workspace/pkg
makes it an archive file
