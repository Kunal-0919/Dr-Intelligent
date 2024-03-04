Dr. Intelligent (AI Doctor predicting if a person is suffering from heart disease.)

Here We Are creating an Artificial Intelligent Doctor that will use Machine Learning Algorithms to Predict
if a Person has a Heart Disease or not.
We have created our intire Website containing landing, uploading and result page, using Django, HTML, CSS, Jinja and Python.

Here we have used PyPDF2 to read(basically converts the whole data on the pdf to a string and then stores all the values in form of key value pairs) and extract values from the PDF of health report of patients. This will be used as the data for the model to predict.
Here the patient will upload his/her health report PDF on our website and then we will extract information from the uplaoded PDF and then train machine learning model on the features value, obtained.

For it We will be using 'Classification' ML Algorithms to -

1. First train the ML model using 80% of data.
2. Then Test the model on 20% of unseen Test Cases to find Accuracy of model.
3. Then we will use this model to Make prediction of User Input PDF Report.
4. Based on the Input Model will generate the PROBABILITY with which it believes that the person has a disease or if person doesn't have a disease.

We are using ML algorithms KNN: K-Nearest Neighbors.

In Supervised learning, our ML Model will train on
Labeled data of 303 patients and then will be used to make
prediction for User INPUT DATA.

WORKING OF KNN:
can be explained on the basis of the below algorithm:

Step-1: Select the K number of the neighbors
Step-2: Calculate the Euclidean distance of K number of neighbors
Step-3: Take the K nearest neighbors as per the calculated Euclidean distance.
Step-4: Among these k neighbors, count the number of the data points of each label(0/1).
Step-5: Assign the new data points to that category for which the number of the neighbor is maximum.
Step-6: Our model is ready.
