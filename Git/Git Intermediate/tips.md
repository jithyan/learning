# Tips

## Ignore files ONLY in your local repo

- Navigate to `.git/info/`
- Open `exlcude`. This is identical to your repo's `.gitignore` but just for your repo only.
- If you already staged some files you wish to ignore locally, run: 

> git update-index --assume-unchanged [<file>...]

