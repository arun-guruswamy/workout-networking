# Team H

##Functionality 
- Added a basic filter for sorting by length and difficulty 
- Added a profile screen so a user can create a profile 

##Limitations 
- Only ran and tested on API 32 
- When creating workouts, must add attributes for specific kind of workout before entering other fields or they will disappear due to lack of data persistence
- Feed can only show 3 posts at this time, any additional posts won't show up
- Cannot filter feeds that contain posts with just a caption and no workout

##Other
- When adding a workout, pick type first {Strength or Cardio} and select attributes. Your choices will be saved despite lack of visual confirmation 
- Creating profile does not have much purpose other than displaying username above posts
- In the filter screen, if a value is left at 0, this means that that field won't be used to filter
- Difficulty is a scale of 1-5, length is in minutes 
- Cardio and Strength were left as separate screens to account for the possibility of adding more features for the specific type of workout
- Difficulty ranges from 1 to 5.


Task list:
- Dynamic State (bundles etc)
- Persistent State (FireStore)
- Following profiles functionality/ Screen (follow requests, accepting followers, )
- authentication


