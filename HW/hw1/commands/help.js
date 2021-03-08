function helper() {
    console.log(`List of all the commands
    1. node wcat.js "filepath.extension" (to view the contents of the file)
    2. node wcat.js "filepath1.extension" "filepath2.extension" "filepath3.extension"... (to view the contents of all the files)
    3. node wcat.js -s "filepath.extension" (convert big line breaks into a singular line break)
    4. node wcat -n "filepath.extension" (give numbering to all the lines) 
    5. node wcat -b "filepath.extension" (give numbering to non-empty lines)
    4. node wcat.js help`);
}
module.exports = {
    helpFn: helper
}