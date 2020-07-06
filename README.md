# PasswordGenerator
A simple password generator

## Why was this made?

- I felt the need to make a password generator that would replace the tedious process of coming up with passwords on my own... which in and of itself was something I'd rarely do anyway - I simply searched for a password-generating site and went with whatever the site would give me according to the criteria I'd specify.
I got sick of doing that and given that I'm currently trying to get the hang of GUI design, I decided to meet a need that often arises by making something that would meet that need. TL;DR: I wanted to make my own password generator to create any passwords I might eventually need so I could then stop using someone else's password generator.

- As mentioned above, I'm trying to get the hang of GUI design, mostly when it comes to designing said GUIs programatically. Making this app is a good excuse to get some practice in.

- I wanted to start a small track record of my progress in app development so that in a few years, I can look back and see how far I've come.

## What's done and what works
![The UI](https://github.com/dcstrp/PasswordGenerator/blob/master/readmeImage/pwgen.png)

It's possible to create the password by selecting a password length from the respective combo box (default length => 12) and then clicking the Generate button. To spare the trouble of having to copy/paste the password from the text area it then appears in, there's a copy-to-clipboard button that stores the password in the clipboard upon clicking.

I initially thought about automatically storing the password on the clipboard upon its creation but decided against it purely because the user might want to choose when the password gets "copied". So, instead of forcing that behaviour upon the user, I decided to give them the choice by having said behaviour behind a button. In the future, perhaps I'll add an option to automatically copy the password to the clipboard for those that would rather have this behaviour happen instead.

## Things to note

The app's current state is fairly rudimentar - it generates a password anywhere between [12,256] charatchers long and right now assumes that numbers/Uppercase letters/lowercase letters/other symbols are meant to be used, which means that the user has no choice in the matter. Given that this might be restrictive and less than optimal in terms of user choices, I'd like to rewrite the underlying generator class in the future so as to allow the user to decide what charatchers they'd like on their password. Furthermore, owing to the fact that no strength checks were implemented, it was decided that 12 would be the lowest length possible to make sure that the passwords have the bare minimum safety.

## Future improvements

- Addition of graphical elements to allow the user to decide between different criteria for their password's creation (lower/UPPER/numbers/symbols/(maybe) other lengths/whether the password gets automatically copied to clipboard).
- If possible, the implementation of a password-strength feature. I'm not entirely sure if I have the necessary knowledge to do this right now but I'd like to learn how to implement this on my own at some point.
