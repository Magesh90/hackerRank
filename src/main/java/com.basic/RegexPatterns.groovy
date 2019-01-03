package com.basic

class RegexPatterns {
    static void main(String[] args) {
        Scanner scan = new Scanner(System.in)
        int rowCount = scan.nextLine() as int
        String[] nameAndEmail = []
        while ({
            nameAndEmail += (scan.nextLine() as String)
            --rowCount
            rowCount > 0
        }());
        scan.close()
        String[] firstNames = []
        nameAndEmail.each { nameWithEmail ->
            String[] splitNameAndEmail = nameWithEmail.split(' ')
            String email = splitNameAndEmail[1]
            if (email ==~ /[\w.]*@gmail\.com/) {
                firstNames += splitNameAndEmail[0]
            }
        }
        firstNames.sort()
        println(firstNames.join('\n'))
    }
}
