# Creating a profile 

##Scope: Workout app 

##Level: User goal 

##Primary actor: Any user(Lurkers, producers, self-documenter)

##Stakeholders and interests: 
- **User**: wants a fast and reliable way to set up an account that will 
not take too long or ask for unneeded private information

##Preconditions: 
- User confirms that they are a certain age via birthday

##Post-conditions
- A new profile is created
- Profile (along with profile information) is stored in easy to access space
- User is now able to access the app 

##Main Success Scenario
###1. Asks user for birthdate to verify that they are of a certain age
###2. System asks user for required personal information
  - Email
  - Date of Birth (already stored from verification step)
  - Username
  - Password
###2. Validate User entries
  - Make sure that the user has a distinct username from the other users
###3. Send email confirmation
###4. User confirms email
###5. Input optional additional details
- Name
- Profile picture
- Workout interests
- Experience level
- Goals
- Bio
- Stats
- Goals
###6. Update system with new user

##Extensions: 
###2a: Username is already taken by another user 
- Keep asking the user for a new name until a unique one is found  
###1a: The birthdate signifies that the hopeful user is not of the correct age
- The user is told they cannot create an account and asked for new birthdate
###4a: User does not receive a conformation email 
- Option to resend the email 
- Option to input a different email to send a conformation to
- Steps can be repeated until user confirms an email 
###4b: User never confirms email 
- a new profile is not able to be made

##Special Requirements

##Technology


