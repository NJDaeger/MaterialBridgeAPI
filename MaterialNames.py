import re

def generate_line(line, materialType, legacyId, currentId, legacyNominal, currentNominal, stack, oldId, oldData):

    base = "public static final Material<" + materialType + "> " + line + " = new Material<>("

    if materialType is not "Block":
        base = base + materialType + ".class, "

    base = base + "\"" + legacyId + "\", "

    if currentId is not "SKIPPED":
        base = base + "\"" + currentId + "\", "

    base = base + "\"" + legacyNominal + "\", "

    if currentNominal is not "SKIPPED":
        base = base + "\"" + currentNominal + "\", "

    if stack is not "64":
        base = base + str(stack)

    if oldId is not "SKIPPED":
        base = base + ", new LegacyData(" + oldId + ", "

    if oldData is "SKIPPED":
        if oldId is not "SKIPPED":
            base = base + "0)"
    else:
        if oldId is not "SKIPPED":
            base = base + oldData + ")"

    return base + ");\n"

def resolve_arg(prompt, default):

    if default is None:
        arg = str(input(prompt + ": "))
        while not arg:
            arg = str(input(prompt + ": "))
    else:
        arg = str(input(prompt + ": "))
        if not arg:
            arg = default

    print(prompt + " set to: " + str(arg))
    return arg

with open('Material.java') as materials:
    start = int(input("Starting Line: "))
    with open('formatted.txt', mode='r+') as new:
        for num, line in enumerate(materials.readlines()):

            if num >= 940: break
            if num < start-1: continue

            if line.startswith("import") or "LEGACY_" in line: continue

            test = re.findall(r'([A-Z_]{3,})', line)
            if not test: continue

            print(test[0])

            matType = resolve_arg("Type", "Block")
            legacyId = resolve_arg("LegacyId", None)
            currentId = resolve_arg("CurrentId", "SKIPPED")
            legacyNom = resolve_arg("LegacyNominal", None)
            currentNom = resolve_arg("CurrentNominal", "SKIPPED")
            stack = resolve_arg("Stack", "64")
            oldId = resolve_arg("OldId", "SKIPPED")
            oldData = resolve_arg("OldData", "SKIPPED")

            line = generate_line(test[0], matType, legacyId, currentId, legacyNom, currentNom, stack, oldId, oldData)
            print(line)
            new.write(line)
            new.flush()
        new.close()
materials.close()
