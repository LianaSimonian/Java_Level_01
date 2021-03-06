Given a PageRenderer class having a print method hat prints header, page and footer using printHeader(), printPage() and printFooter() methods.

pageRenderer#print() prints the following:
"Header"
"Page"
"Footer"

Create a TopPageNumberAwarePageRenderer that extends from PageRenderer and by reusing the printHeader(), printPage() and printFooter() super class methods prints the header, page number, page and footer.

topPageNumberAwarePageRenderer#print() prints the following:

"Header"
"Page Number"
"Page"
"Footer"

Create a TopAndDownPageNumberAwarePageRenderer that extends from TopPageNumberAwarePageRenderer and by reusing the superclass methods print the following content:

"Header"
"Page Number"
"Page"
"Page Number"
"Footer"
override չենք անում print() printHeader() printPage() և printFooter() method-ները